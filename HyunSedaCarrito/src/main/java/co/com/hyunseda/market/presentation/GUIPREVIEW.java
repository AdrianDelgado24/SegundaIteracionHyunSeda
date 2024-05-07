package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.acess.Factory;
import co.com.hyunseda.market.domain.acess.IProductRepository;
import co.com.hyunseda.market.main.HyunSedaSolid;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import co.com.hyunseda.market.infrastructure.Observer;
import co.com.hyunseda.market.service.CategoryService;
import co.unicauca.pago.common.entities.Pago;
import co.unicauca.pago.core.PagoCore;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;

/**
 *
 * @author Libardo
 */
public class GUIPREVIEW extends javax.swing.JFrame implements Observer{

    private final ProductService service;
    private List<Product> products;
    
    private CategoryService categoryService;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;

    /**
     * Creates new form GUIDishes2
     */
    public GUIPREVIEW() {
        initComponents();
        initializeTable();
        //fillComboBox();
        
        IProductRepository repo = Factory.getInstance().getProductRepository("default");
        service = new ProductService(repo);
        loadCategories();
        loadAllProducts();
        setLocationRelativeTo(null);
        setSize(1000, 500);
    }
    public GUIPREVIEW(CategoryService categoryService,ProductService productService, ShoppingCartService shoppingCartService) {
    initComponents();
    initializeTable();
    
    IProductRepository repo = Factory.getInstance().getProductRepository("default");
    service = new ProductService(repo);
    
    this.categoryService = categoryService;
    this.productService = productService;
    this.shoppingCartService = shoppingCartService;
    
    
    loadAllProducts();
    loadCategories();
    setLocationRelativeTo(null);
    setSize(1000, 500);
    }
     
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Name","Price" 
                }
        ));
    }
    private void fillTable() {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        List<Product> listProducts = shoppingCartService.getCart().getCarro();
        Object rowData[] = new Object[2];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductName();
            rowData[1] = listProducts.get(i).getProductPrice();
            model.addRow(rowData);
        }
    }
    private void fillComboBox(){
        productService.findAllProducts();
        for(int i =0; i<productService.findAllProducts().size();i++){
            cboCategories.addItem(productService.findAllProducts().get(i).getProductName());
            System.out.println("si son cate" +cboCategories );
                //addItem(productService.findAllProducts().get(i).getProductName());
        }
    }
      
   private void loadProductName(String name) {
        try {
            products = service.findAllProductsByName(name);
            DefaultListModel listModel = new DefaultListModel();

            for (Product product : products) {
                if(product.getProductName().equalsIgnoreCase(name))
                listModel.addElement(product.getProductName());
            }
            lstProducts.setModel(listModel);
        } catch (Exception ex) {
            Logger.getLogger(GUIPREVIEW.class.getName()).log(Level.SEVERE, "Error al cargar categoria", ex);
        }
    }

    private void loadAllProducts() {
        try {
            products = service.findAllProducts();
            DefaultListModel listModel = new DefaultListModel();

            for (Product product : products) {
                listModel.addElement(product.getProductName());
            }
            lstProducts.setModel(listModel);
        } catch (Exception ex) {
            Logger.getLogger(GUIPREVIEW.class.getName()).log(Level.SEVERE, "Error al cargar los pructos", ex);
        }
    }
    private void loadCategories() {
        
        categoryService.listCategory();
        cboCategories.addItem("<Todas>");
       
        for (Category category : categoryService.listCategory()) {
            cboCategories.addItem(category.getCategoryName().toString());
            System.out.println(cboCategories);
        }
    }
 
    private void loadProductsByCategory(String category) {
        try {
            products = service.findByCategory(category);
            DefaultListModel listModel = new DefaultListModel();

            for (Product product : products) {
                listModel.addElement(product.getProductName());
            }
            lstProducts.setModel(listModel);
        } catch (Exception ex) {
            Logger.getLogger(GUIPREVIEW.class.getName()).log(Level.SEVERE, "Error al cargar las categorias", ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        lblImage = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorte = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboCategories = new javax.swing.JComboBox<>();
        btnAgregarCarrito = new javax.swing.JButton();
        pnlSur = new javax.swing.JPanel();
        txtPago = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        lblCuenta = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnRealizarPago = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos de Huyn Seda");

        pnlCentro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCentro.setLayout(new java.awt.GridLayout(1, 4));

        lstProducts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstProducts);

        pnlCentro.add(jScrollPane1);

        lblImage.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));
        pnlCentro.add(lblImage);

        lblDescription.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        lblDescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        pnlCentro.add(lblDescription);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(tblProducts);

        pnlCentro.add(jScrollPane3);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N
        pnlNorte.add(jLabel3);

        jLabel1.setFont(new java.awt.Font("TeXGyreHeros", 3, 24)); // NOI18N
        jLabel1.setText("Hyun Seda");
        pnlNorte.add(jLabel1);

        jLabel2.setText("    Categoría:");
        pnlNorte.add(jLabel2);

        cboCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriesActionPerformed(evt);
            }
        });
        pnlNorte.add(cboCategories);

        btnAgregarCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrito.png"))); // NOI18N
        btnAgregarCarrito.setText("Agregar al carrito");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });
        pnlNorte.add(btnAgregarCarrito);

        getContentPane().add(pnlNorte, java.awt.BorderLayout.NORTH);

        txtPago.setText("Pago:");
        pnlSur.add(txtPago);

        cbxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paypal", "Google Pay", "Stripe" }));
        pnlSur.add(cbxMetodoPago);

        lblCuenta.setText("#Cuenta:");
        pnlSur.add(lblCuenta);

        txtCuenta.setText("0000");
        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
            }
        });
        pnlSur.add(txtCuenta);

        jLabel4.setText("                         ");
        pnlSur.add(jLabel4);

        btnRealizarPago.setText("Pagar");
        btnRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagoActionPerformed(evt);
            }
        });
        pnlSur.add(btnRealizarPago);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar.png"))); // NOI18N
        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlSur.add(btnClose);

        jLabel6.setText("                           ");
        pnlSur.add(jLabel6);

        txtTotal.setText("Total:");
        pnlSur.add(txtTotal);

        lblTotal.setText("0");
        pnlSur.add(lblTotal);

        jLabel7.setText("                         ");
        pnlSur.add(jLabel7);

        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    /**
     * Al hacer clic en el item del jList se muestra la imagen y la descripción
     *
     * @param evt
     */
    private void lstProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProductsMouseClicked
        int i = lstProducts.getSelectedIndex();
        if (i >= 0) {
            // Coloca la descripción
            StringBuilder sb = new StringBuilder(64);
            sb.append("<html>" + products.get(i).getProductDescripcion()
                    + "<br><br>Precio: " + products.get(i).getProductPrice()
                    //+ "<br><br>Categorías: " + products.get(i).getCategoriasSecundarias().toString()
                    + "</html>");
            lblDescription.setText(sb.toString());
            // Coloca el titulo de la imagen
            lblImage.setBorder(javax.swing.BorderFactory.createTitledBorder(products.get(i).getProductName()));
            // Coloca la imagen
            String nameString = products.get(i).getProductPhoto();
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ImageIcon imageIcon = Utilities.loadImageFromCloud(nameString);
            if (imageIcon != null) {
                lblImage.setIcon(imageIcon);
            }
            setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_lstProductsMouseClicked

    private void cboCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriesActionPerformed
        if (cboCategories.getSelectedIndex() == 0) {
            loadAllProducts();
            System.out.println("hola"+cboCategories);
        } else {
            loadProductsByCategory(cboCategories.getSelectedItem().toString());
        }
        
    }//GEN-LAST:event_cboCategoriesActionPerformed

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
       int i = lstProducts.getSelectedIndex();
       if(i >= 0){
            String nomProducto = products.get(i).getProductName();
              //getSelectedItem().toString();
          // System.out.println(nomProducto);
       Product producto = productService.findProductByName(nomProducto);
               // findProductAllByName(nomProducto);
               //System.out.println("soy el producto"+producto);
        shoppingCartService.aniadirProducto(producto);
         fillTable();
       }
       
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void btnRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagoActionPerformed
         double total = Double.parseDouble(lblTotal.getText());
        if(total == 0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String codigoCuenta = txtCuenta.getText();
        Object selectedObject = cbxMetodoPago.getSelectedItem();
        String metodoPago = selectedObject.toString();
        
     
        if(codigoCuenta.isEmpty() ||codigoCuenta.isBlank()){
            JOptionPane.showMessageDialog(null, "No ha colocado ninguna cuenta asociada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Pago exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
            
        
        /*PagoCore pg = new PagoCore();
        
        boolean pago =  pg.pagar(codigoCuenta, total, metodoPago,getBaseFilePath());
        if(pago){
            JOptionPane.showMessageDialog(null, "EL pago fue exitoso :", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "EL pago rechazado: ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }*/
    }//GEN-LAST:event_btnRealizarPagoActionPerformed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaActionPerformed
    private String getBaseFilePath() {
        try {
            String path = HyunSedaSolid.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PagoCore.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }
    private void totalPrecio(List<Product> listProducts){
           double total=0;
           for(int i = 0; i < listProducts.size();i++){
               total += listProducts.get(i).getProductPrice();
           }
           lblTotal.setText(String.valueOf(total));
     }
    
    @Override // total de la compra
    public void update(Object o) {
        ShoppingCartService aux =(ShoppingCartService)o;
        totalPrecio(aux.getCart().getCarro());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPREVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRealizarPago;
    private javax.swing.JComboBox<String> cboCategories;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<String> lstProducts;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JLabel txtPago;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
