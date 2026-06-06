/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author oem
 */


public class Estoque extends javax.swing.JFrame {
    
    
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    /**
     * Creates new form Produtos
     */
    public Estoque() {
        initComponents();
         conexao = ModuloConexao.conector();
         
         pesquisar_fornecedores();
         
//         pesquisar_fornecedores_por_id();
         
         

         
    }
         

// 3. Popula a ComboBox com os dados
//for (String nome : listaDeNomes) {
//    ForId.addItem(nome);
//}
//    }
    
//    ForId.removeAllItems();

// 2. Exemplo de lista vinda do seu Banco de Dados
     private void update_setar_qtd_estoque_(){
           
             String sql = "update  tb_produtos  set   qtd_estoque=?  where  id=?";
             try{
                  int numberID = Integer.parseInt(Id.getText());
                 
                 
//            int preco = Integer.parseInt(Preco.getText());
            int qtd = Integer.parseInt(QtdEstoque.getText());      
//            int forId = Integer.parseInt(ForId.getSelectedItem().toString());


            
            pst=conexao.prepareStatement(sql);
            
//            pst.setString(1,  IdField.getText());            
//            pst.setString(1, Nome.getText()); 
//            pst.setString(2, Descricao.getText());   
//            pst.setInt(3, preco);       
            pst.setInt(1, qtd); 
//            pst.setInt(5, forId);  
            pst.setInt(2, numberID);   

 
             

      if(Nome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
                
                
            }else{
            
             int adicionado =     pst.executeUpdate();
            
                          

            if(adicionado > 0){
                
               JOptionPane.showMessageDialog(null,"Produto Atualizado com sucesso!");
//              
               
               limpar_campos();
                 
//                  AddButton.setEnabled(true);
              
            }
            }
             }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          }
     
     
        private void update_somarr_qtd_estoque_(){
           
             String sqlSelct = "select qtd_estoque from   tb_produtos  where  id=?";
             
             String sqlUpdate = "update  tb_produtos  set   qtd_estoque=?  where  id=?";

             try{
                  int numberID = Integer.parseInt(Id.getText());
                 
                 
//            int preco = Integer.parseInt(Preco.getText());
            int qtd = Integer.parseInt(QtdEstoque.getText());      
//            int forId = Integer.parseInt(ForId.getSelectedItem().toString());


            
            pst=conexao.prepareStatement(sqlUpdate);
            
//            pst.setString(1,  IdField.getText());            
//            pst.setString(1, Nome.getText()); 
//            pst.setString(2, Descricao.getText());   
//            pst.setInt(3, preco);       
            pst.setInt(1, qtd); 
//            pst.setInt(5, forId);  
            pst.setInt(2, numberID);   

 
             

      if(Nome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
                
                
            }else{
            
             int adicionado =     pst.executeUpdate();
            
                          

            if(adicionado > 0){
                
               JOptionPane.showMessageDialog(null,"Produto Atualizado com sucesso!");
//              
               
               limpar_campos();
                 
//                  AddButton.setEnabled(true);
              
            }
            }
             }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          }
    
        private void adicionar(){
            int Global = 0;

        String sql = "insert into  tb_produtos (nome, descricao, preco, qtd_estoque, for_id) values( ?, ?, ? , ?, ?)";
        try{
            int preco = Integer.parseInt(QtdAtual.getText());
            int qtd = Integer.parseInt(QtdEstoque.getText());      
//            int forId = Integer.parseInt(Index.getText());
            
//            int FOR;
//            FOR = Integer.parseInt(ForId.(rs.getString("id")));
            
//            Global = 

               
            
            pst=conexao.prepareStatement(sql);
//            pst.setString(1,  IdField.getText());            
            pst.setString(1, Nome.getText()); 
            pst.setString(2, Descricao.getText());   
            pst.setInt(3, preco);       
            pst.setInt(4, qtd); 
            
          
//            pst.setInt(5, forId);
               
   
            
            if(Nome.getText().isEmpty() || QtdAtual.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
                
                
            }else{
            
             int adicionado =     pst.executeUpdate();
            
                          

            if(adicionado > 0){
                
               JOptionPane.showMessageDialog(null,"Produto Cadastrado com sucesso!");
               
                     limpar_campos();

              
            }
            }
             }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
        
            public void pesquisar_fornecedores(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                


//String query = "SELECT * FROM TABELA WHERE CONDICAO = TAL";


          try{
              
//                  List<String> ForId = new ArrayList<String>();
                    
                                        String sql = "select id, nome from tb_fornecedores";
               pst=conexao.prepareStatement(sql);
               
//               pst.setString(1, ConsultaNome.getText() + "%");
               
                     rs= pst.executeQuery();
                     
                     
      

                     while(rs.next()){

//       ForId.addItem(rs.getString("nome"));

   }
                     
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
            
            
            
//              public void pesquisar_fornecedores_por_id(){
////          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
//                
//
//
////String query = "SELECT * FROM TABELA WHERE CONDICAO = TAL";
//
//
//          try{
//              
////                  List<String> ForId = new ArrayList<String>();
//                    
//                                        String sql = "select id from tb_fornecedores";
//               pst=conexao.prepareStatement(sql);
//               
////               pst.setString(1, ConsultaNome.getText() + "%");
//               
//                     rs= pst.executeQuery();
//                         
//                
//                    
//                     
//
//                     while(rs.next()){
//
//      Auda.addItem(rs.getString("id"));
//
//   }
//                     
//          
//              }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//          
//           
//      }
            
            
//        
//            public void pesquisar_cliente(){
////          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
//                    String sql = "select * from tb_produtos where  nome like ?";
//
//          try{
//               pst=conexao.prepareStatement(sql);
//               
//               pst.setString(1, ConsultaNome.getText() + "%");
//               
//                     rs= pst.executeQuery();
//                     
//                     Tabela.setModel(DbUtils.resultSetToTableModel(rs));
//          
//              }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//          
//           
//      }

            
            
                public void pesquisar_produtos(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                    String sql = "select * from tb_produtos";
//                                        String sql = "select * from tb_produtos where  nome like ?";


          try{
               pst=conexao.prepareStatement(sql);
               
//               pst.setString(1, ConsultaNome.getText() + "%");
               
                     rs= pst.executeQuery();
                     
                     Tabela.setModel(DbUtils.resultSetToTableModel(rs));
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
                
                   public void setar_campos(){
            int setar = Tabela.getSelectedRow();
            
               Id.setText(Tabela.getModel().getValueAt(setar, 0).toString());  
               Nome.setText(Tabela.getModel().getValueAt(setar, 1).toString()); 
                Descricao.setText(Tabela.getModel().getValueAt(setar, 2).toString());   
               QtdAtual.setText(Tabela.getModel().getValueAt(setar, 4).toString());
//               ForId.setText(Tabela.getModel().getValueAt(setar, 5).toString());
             


//               AddButton.setEnabled(false);

        }
            
            
            
             public void pesquisar_combobox(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                    String sql = "select id from tb_fornecedores where nome=?";

          try{
               pst=conexao.prepareStatement(sql);
               
//               String Name = Integer.parseInt(ForId.getSelectedItem().toString()); 
//               String Name =ForId.getSelectedItem().toString();

               
//               pst.setString(1,Name);
               
               
                     rs= pst.executeQuery();
                     
                     
//                     Tabela.setModel(DbUtils.resultSetToTableModel(rs));
                     
                     
                     while(rs.next()){

//     Index.setText(rs.getString("id").toString());

   }
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
             
                   public void pesquisar_produtos_for_id(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                    String sql = "select p.id, p.nome, p.descricao, p.preco, p.qtd_estoque, f.nome as fornecedores from tb_produtos as p inner join tb_fornecedores as f on(p.for_id=f.id)";

          try{
               pst=conexao.prepareStatement(sql);
               
//               pst.setString(1, ConsultaNome.getText() + "%");
               
                     rs= pst.executeQuery();
                     
//                     Tabela.setModel(DbUtils.resultSetToTableModel(rs));
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
        
         
         private void limpar_campos(){
             
             
               Id.setText("");
                     Nome.setText("");  
                Descricao.setText("");           
                QtdAtual.setText("");
                 QtdEstoque.setText("");
//                 ForId.setText("");
              


                 
                 
//                 ((DefaultTableModel) Tabela.getModel()).setRowCount(0);
                 
           
       }
         
                 
                 
       private void deletar(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse produto?", "Atenção", JOptionPane.YES_NO_OPTION);
        
      if(confirma ==JOptionPane.YES_OPTION)  {
          String sql = "delete from tb_produtos  where id=?";
          
          try{
              pst=conexao.prepareStatement(sql);
               int numberID = Integer.parseInt(Id.getText());
              
              pst.setInt(1, numberID);
              
               int apagado =   pst.executeUpdate();
               
               if(apagado > 0){
                   
              
                JOptionPane.showMessageDialog(null,"Produto deletado com sucesso!");
              
               limpar_campos();
               
//               AddButton.setEnabled(true);
                
                               }

              
                }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      }
       }
         
//            public void setar_campos(){
//            int setar = Tabela.getSelectedRow();
//            
//               Id.setText(Tabela.getModel().getValueAt(setar, 0).toString());  
//               Nome.setText(Tabela.getModel().getValueAt(setar, 1).toString()); 
//                Descricao.setText(Tabela.getModel().getValueAt(setar, 2).toString());   
//               QtdAtual.setText(Tabela.getModel().getValueAt(setar, 3).toString());
//               QtdEstoque.setText(Tabela.getModel().getValueAt(setar, 4).toString());     
////               ForId.setText(Tabela.getModel().getValueAt(setar, 5).toString());
//             
//
//
////               AddButton.setEnabled(false);
//
//        }
            
            
//          private void update(){
//           
//             String sql = "update  tb_produtos  set   nome=?, descricao=?, preco=? , qtd_estoque=?, for_id=?  where  id=?";
//             try{
//                  int numberID = Integer.parseInt(Id.getText());
//                 
//                 
//            int preco = Integer.parseInt(QtdAtual.getText());
//            int qtd = Integer.parseInt(QtdEstoque.getText());      
//            int forId = Integer.parseInt(ForId.getSelectedItem().toString());
//
//
//            
//            pst=conexao.prepareStatement(sql);
////            pst.setString(1,  IdField.getText());            
//            pst.setString(1, Nome.getText()); 
//            pst.setString(2, Descricao.getText());   
//            pst.setInt(3, preco);       
//            pst.setInt(4, qtd); 
//            pst.setInt(5, forId);  
//            pst.setInt(6, numberID);   
//
// 
//             
//
//      if(Nome.getText().isEmpty()){
//                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
//                
//                
//            }else{
//            
//             int adicionado =     pst.executeUpdate();
//            
//                          
//
//            if(adicionado > 0){
//                
//               JOptionPane.showMessageDialog(null,"Produto Atualizado com sucesso!");
////              
//               
//               limpar_campos();
//                 
////                  AddButton.setEnabled(true);
//              
//            }
//            }
//             }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//          }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Descricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        QtdAtual = new javax.swing.JTextField();
        QtdEstoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NovoButton = new javax.swing.JButton();
        SalvarButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(21, 14, 14));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(238, 250, 250));
        jLabel1.setText("Estoque");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel2.setText("ID");

        jLabel3.setText("Nome");

        jLabel4.setText("Descrição");

        jLabel5.setText("Quantidade Atual");

        jLabel6.setText("Quantidade no Estoque");

        NovoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        NovoButton.setToolTipText("Novo");
        NovoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoButtonActionPerformed(evt);
            }
        });

        SalvarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/diskette-45.png"))); // NOI18N
        SalvarButton.setToolTipText("Salvar");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/update.png"))); // NOI18N
        jButton4.setToolTipText("Editar Cliente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove_icon_pequeno.png"))); // NOI18N
        jButton3.setToolTipText("Editar Cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Tabela.setBorder(null);
        Tabela.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4", "Título 5", "Fornecedores"
            }
        ));
        Tabela.setRowHeight(26);
        Tabela.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TabelaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        Tabela.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TabelaComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(Tabela);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.setPreferredSize(new java.awt.Dimension(147, 68));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add-30.png"))); // NOI18N
        jButton2.setText("Setar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Somar QTD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(QtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(QtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(NovoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(532, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(428, 428, 428)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(QtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(QtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SalvarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NovoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Dados do Produto", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_TabelaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deletar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

//        update();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        adicionar();

        // TODO add your handling code here:
    }//GEN-LAST:event_SalvarButtonActionPerformed

    private void NovoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoButtonActionPerformed
        limpar_campos();
        // TODO add your handling code here:
    }//GEN-LAST:event_NovoButtonActionPerformed

    private void TabelaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TabelaAncestorAdded
        // TODO add your handling code here:
        pesquisar_produtos();
    }//GEN-LAST:event_TabelaAncestorAdded

    private void TabelaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TabelaComponentShown
        // TODO add your handling code here:
        pesquisar_produtos();
    }//GEN-LAST:event_TabelaComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
                  pesquisar_produtos();

       
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          
           update_setar_qtd_estoque_();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descricao;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Nome;
    private javax.swing.JButton NovoButton;
    private javax.swing.JTextField QtdAtual;
    private javax.swing.JTextField QtdEstoque;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JTable Tabela;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    // End of variables declaration//GEN-END:variables
}
