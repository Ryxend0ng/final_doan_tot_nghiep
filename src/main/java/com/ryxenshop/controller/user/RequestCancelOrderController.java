package com.ryxenshop.controller.user;

import com.ryxenshop.controller.BaseController;
import com.ryxenshop.entities.AttributeProduct;
import com.ryxenshop.entities.Order;
import com.ryxenshop.entities.OrderDetail;
import com.ryxenshop.entities.RequestCancelOrder;
import com.ryxenshop.service.AttributeProductService;
import com.ryxenshop.service.OrderService;
import com.ryxenshop.service.RequestCancelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/ryxen-shop/")
public class RequestCancelOrderController extends BaseController {

    @Autowired
    private AttributeProductService attrService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private RequestCancelOrderService requestCancelOrderService;

    @GetMapping("request-cancel-order")
    public ResponseEntity<Boolean> requestCancelOrder(@RequestParam("idOrder") String idOrder,
                                                      @RequestParam("reason") String reason) throws Exception {
        Order saleOrder = orderService.findById(idOrder);
        RequestCancelOrder requestCancelOrder = new RequestCancelOrder();
        requestCancelOrder.setCreatedBy(saleOrder.getUserID());
        requestCancelOrder.setCustomerName(saleOrder.getCustomerName());
        requestCancelOrder.setEmail(saleOrder.getCustomerEmail());
        requestCancelOrder.setRequestType("hủy đơn hàng");
        requestCancelOrder.setMessage("Khách hàng gửi yêu cầu hủy đơn hàng có mã " + saleOrder.getCode());
        requestCancelOrder.setCreatedDate(Calendar.getInstance().getTime());
        requestCancelOrder.setStatus(false);
        requestCancelOrder.setOrder(saleOrder);
        requestCancelOrder.setReason(reason);
        requestCancelOrder.setProcessingStatus(false);
        requestCancelOrderService.saveOrUpdate(requestCancelOrder);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("request-cancel-order-status")
    public ResponseEntity<Boolean> requestCancelOrderStatus(@RequestParam("idOrder") String idOrder) throws Exception {
        Order saleOrder = orderService.findById(idOrder);
        RequestCancelOrder requestCancelOrder = new RequestCancelOrder();
        requestCancelOrder.setCreatedBy(saleOrder.getUserID());
        requestCancelOrder.setCustomerName(saleOrder.getCustomerName());
        requestCancelOrder.setEmail(saleOrder.getCustomerEmail());
        requestCancelOrder.setRequestType("hủy đơn hàng");
        requestCancelOrder.setMessage("Khách hàng gửi yêu cầu hủy đơn hàng có mã " + saleOrder.getCode());
        requestCancelOrder.setCreatedDate(Calendar.getInstance().getTime());
        requestCancelOrder.setStatus(false);
        requestCancelOrder.setOrder(saleOrder);
        requestCancelOrder.setReason("");
        requestCancelOrder.setProcessingStatus(true);
        requestCancelOrderService.saveOrUpdate(requestCancelOrder);
        Order order = orderService.findById(idOrder);
        if (order == null) {
            return ResponseEntity.ok(null);
        }
        Integer status =4;
        List<OrderDetail> orderDetails = order.getOrderDetails();
        AttributeProduct attributeProduct = null;
        for (OrderDetail orderDetail : orderDetails) {
            attributeProduct = orderDetail.getAttributeProduct();
            attributeProduct.setAmount(status == 4 ? attributeProduct.getAmount() + orderDetail.getQuantity()
                    : attributeProduct.getAmount() - orderDetail.getQuantity());
            attrService.saveOrUpdate(attributeProduct, getUserLogined());
        }

        order.setProcessingStatus(status);
        orderService.saveOrUpdate(order, getUserLogined());
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
