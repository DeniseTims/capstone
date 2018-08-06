package org.launchcode.models.forms;

import org.launchcode.models.Product;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int productId;

    private Iterable<Product> product;

    private Menu menu;

    public AddMenuItemForm() { }

    public AddMenuItemForm(Iterable<Product> products, Menu menu) {

        this.product = product;
        this.menu = menu;
    }

    public int getMenuId() { return menuId; }

    public void setMenuId(int menuId) { this.menuId = menuId; }

    public int getProductId() { return productId; }

    public void setProductId(int productId) { this.productId = productId; }

    public Iterable<Product> getProduct() { return product; }

    public Menu getMenu() { return menu; }
}
