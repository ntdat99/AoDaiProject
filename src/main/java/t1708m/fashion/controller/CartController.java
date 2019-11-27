package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import t1708m.fashion.entity.HelloOrder;
import t1708m.fashion.entity.HelloOrderDetail;
import t1708m.fashion.entity.Product;
import t1708m.fashion.entity.ShopingCart;
import t1708m.fashion.service.ProductService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    private static final String SHOPPING_CART_ATTRIBUTE = "SHOPPING_CART";
    private static final Logger LOGGER = Logger.getLogger(CartController.class.getSimpleName());

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public String addCart(HttpSession session,
                          HttpServletResponse response,
                          @RequestParam(name = "productId") long id,
                          @RequestParam(name = "quantity", defaultValue = "1") int quantity) {
        Product product = productService.getById(id);
        if (product == null) {
            response.setStatus(404);
            return "NOT FOUND";
        }
        ShopingCart cart = loadCart(session);
        LOGGER.log(Level.SEVERE, ("Cart null: " + (cart == null)));
        cart.addProduct(product, quantity);
        session.setAttribute(SHOPPING_CART_ATTRIBUTE, cart);
        return "Okie";
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/remove")
    @ResponseBody
    public String removeCart(HttpSession session,
                             @RequestParam(name = "productId") long id) {
        ShopingCart cart = loadCart(session);
        cart.removeProduct(id);
        return "Okie";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public String getCart(HttpSession session, Model model) {
        ShopingCart cart = loadCart(session);
        model.addAttribute("cart", cart);
        return "/client/shoping-cart";
    }

    private ShopingCart loadCart(HttpSession session) {
        ShopingCart cart = null;
        try {
            cart = (ShopingCart) session.getAttribute(SHOPPING_CART_ATTRIBUTE);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, String.format("Can't get cart from session: "), ex);
        }
        if (cart == null) {
            cart = new ShopingCart();
        }
        return cart;
    }
}
