package quanlysanpham.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import quanlysanpham.model.Product;
import quanlysanpham.service.ProductService;

import javax.xml.ws.Response;

@Controller
public class ProductManage {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String list(Model model) {

        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("quanlysanpham/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("quanlysanpham/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int)(Math.random() * 10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","Thêm sản phẩm thành công");
        return "redirect:/";
    }
    @GetMapping("product/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("product/update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Modified product successfully!");
        return "redirect:/";
    }
    @GetMapping("product/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "delete";
    }
    @PostMapping("product/delete")
    public String delete(Product product,RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted product successfully!");
        return "redirect:/";
    }
    @GetMapping("product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
