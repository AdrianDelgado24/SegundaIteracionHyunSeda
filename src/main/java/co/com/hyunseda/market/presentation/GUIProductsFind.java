package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.com.hyunseda.market.infrastructure.Observer;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.acess.ProductRepository;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;
import java.util.ArrayList;




public class GUIProductsFind extends javax.swing.JDialog {
    ProductService productService;
    CategoryService categoryService;
    private ShoppingCartService shoppingCartService;
    /**
     * Creates new form GUIProductsFind
     */
    public GUIProductsFind(java.awt.Frame parent, boolean modal,ProductService productService,ShoppingCartService shoppingCartService) {
        super(parent, modal);
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        initComponents();
        initializeTable();
        //loadData();
        setLocationRelativeTo(null); 
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name","Description","Stock","Categories"
                }
        ));
    }
    
    private void loadData() {
        initializeTable();
        List<Product> result = productService.listProducts();
        this.initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

       Object rowData[] = new Object[8];//No columnas
        for (int i = 0; i < result.size(); i++) {
            rowData[0] = result.get(i).getProductId();
            rowData[1] = result.get(i).getProductName();
            rowData[2] = result.get(i).getProductDescripcion();
            rowData[3] = "" + result.get(i).getProductStock();
            
             /*for (int j = 0; j < listProducts.get(i).getCategoriasSecundarias().size(); j++) {
                System.out.print("Producto: " + listProducts.get(i).getProductName());
                System.out.print("CategoriaPrincipal: " + listProducts.get(i).getCategory().getCategoryId());
                System.out.print("CategoriasSecundarias: " + listProducts.get(i).getCategoriasSecundarias());
               categoriass = categoriass + listProducts.get(i).getCategoriasSecundarias().get(j).getCategoryId()+ " ";
            }
            rowData[3] = categoriass;*/
            
           /* String categories="";
            if (result.get(i).getCategoriasSecundarias() != null){
                for(Category cat: result.get(i).getCategoriasSecundarias()){
                    //categories = categories + "," + cat.getCategoryName();
                    categories = categories + cat.getCategoryId()+ cat.getCategoryName();
                }
            }*/
            ////
             
            String categories = "";
            if (result.get(i).getCategoriasSecundarias() != null) {
                for (Category cat : result.get(i).getCategoriasSecundarias()) {
                    categories += cat.getCategoryId() + " " + cat.getCategoryName() + ", ";
                }
            }
            if (!categories.isEmpty()) {
                categories = categories.substring(0, categories.length() - 2);
            }
            rowData[4] = "" + categories;
            ////
            

            model.addRow(rowData);
        }    

    }
   
    private void loadProductsByCategory (int category) {

    initializeTable();
        List<Product> result = productService.findAllProductsByCategoryId(category);
        this.initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

       Object rowData[] = new Object[8];//No columnas
        for (int i = 0; i < result.size(); i++) {
            rowData[0] = result.get(i).getProductId();
            rowData[1] = result.get(i).getProductName();
            rowData[2] = result.get(i).getProductDescripcion();
            rowData[3] = "" + result.get(i).getProductStock();

             
            String categories = "";
            if (result.get(i).getCategoriasSecundarias() != null) {
                for (Category cat : result.get(i).getCategoriasSecundarias()) {
                    categories += cat.getCategoryId() + " " + cat.getCategoryName() + ", ";
                }
            }
            if (!categories.isEmpty()) {
                categories = categories.substring(0, categories.length() - 2);
            }
            rowData[4] = "" + categories;
            ////
            

            model.addRow(rowData);
        }    
    
   
        

       
    }
    private void loadDataByName(String name) {
        initializeTable();
        List<Product> result = productService.findAllProductsByName(name);
        this.initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[8];
        for (int i = 0; i < result.size(); i++) {
            rowData[0] = result.get(i).getProductId();
            rowData[1] = result.get(i).getProductName();
            rowData[2] = result.get(i).getProductDescripcion();
            rowData[3] = "" + result.get(i).getProductStock();
            
            String categories = "";
            if (result.get(i).getCategoriasSecundarias() != null) {
                for (Category cat : result.get(i).getCategoriasSecundarias()) {
                    categories += cat.getCategoryId() + " " + cat.getCategoryName() + ", ";
                }
            }
            if (!categories.isEmpty()) {
                categories = categories.substring(0, categories.length() - 2);
            }
            rowData[4] = "" + categories;

            model.addRow(rowData);
        }
    }
    
    private void loadDataById(int id) {
        initializeTable();
        Product result = productService.findProductById(id);
        this.initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

       /* Object rowData[] = new Object[5];//No columnas
        
        rowData[0] = result.getProductId();
        rowData[1] = result.getProductName();
        rowData[2] = result.getProductDescripcion();
        rowData[3] = "" + result.getProductStock();
        
        rowData[4] = "" +result.getCategoriasSecundarias();

        model.addRow(rowData);*/
        /////
        // Verificar si el producto existe
        if (result != null) {
            //DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

            // Crear un array para contener los datos de la fila
            Object rowData[] = new Object[5]; // Número de columnas

            // Llenar el array con los datos del producto
            rowData[0] = result.getProductId();
            rowData[1] = result.getProductName();
            rowData[2] = result.getProductDescripcion();
            rowData[4] = result.getProductStock(); 
            rowData[4] = result.getCategoriasSecundarias(); 

            String categories = "";
            if (result.getCategoriasSecundarias()!= null) {
                for (Category cat : result.getCategoriasSecundarias()) {
                    categories += cat.getCategoryId() + " " + cat.getCategoryName() + ", ";
                }
            }
            if (!categories.isEmpty()) {
                categories = categories.substring(0, categories.length() - 2);
            }
            rowData[4] = "" + categories;
          
            model.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado para el ID: " + id, "Mensaje", JOptionPane.ERROR_MESSAGE);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdoId = new javax.swing.JRadioButton();
        rdoName = new javax.swing.JRadioButton();
        rdoCategories = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProducts);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Buscar por:");
        pnlNorth.add(jLabel1);

        buttonGroup1.add(rdoId);
        rdoId.setSelected(true);
        rdoId.setText("Id");
        pnlNorth.add(rdoId);

        buttonGroup1.add(rdoName);
        rdoName.setText("Nombre del producto");
        pnlNorth.add(rdoName);

        rdoCategories.setText("Categoria");
        pnlNorth.add(rdoCategories);

        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));
        pnlNorth.add(txtSearch);

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearch);

        btnSearchAll.setText("Buscar Todos");
        btnSearchAll.setPreferredSize(new java.awt.Dimension(120, 25));
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearchAll);

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
       GUIMENUPRODUCTO abrir = new GUIMENUPRODUCTO(categoryService,productService,shoppingCartService);
        abrir.setVisible(true);
        this.setVisible(false); 
        
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        /*fillTable(productService.listProducts());*/
        loadData();
    }//GEN-LAST:event_btnSearchAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try
        {
            if(rdoId.isSelected() && !"".equals(txtSearch.getText()))
        {
            String id = txtSearch.getText().trim();
            int idProduct = Integer.parseInt(id);
           loadDataById(idProduct); 
        }else if(!"".equals(txtSearch.getText()))
        {
            loadDataByName(txtSearch.getText());
        }
        else if(!"".equals(txtSearch.getText())){
            loadDataByName(txtSearch.getText());
        }
        else{
            JOptionPane.showMessageDialog(null, "No ingreso un  parámetro a buscar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "Índice fuera de rango", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion correcta", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JRadioButton rdoCategories;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
