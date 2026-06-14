/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.ModuloConexao;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author oem
 */
public class Vendas extends javax.swing.JFrame {
    
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    double preco, subtotal, total;
    int qtd;
    
    DefaultTableModel meus_produtos;


    /**
     * Creates new form Vendas
     */
    public Vendas() {
        initComponents();

  conexao = ModuloConexao.conector();
    
}
    
         
                public void pesquisar_produtos(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                    String sql = "select id, nome, descricao, preco, qtd_estoque from tb_produtos";

          try{
               pst=conexao.prepareStatement(sql);
               
//               pst.setString(1, ConsultaNome.getText() + "%");
               
                     rs= pst.executeQuery();
                     
                     TabelaProdutos.setModel(DbUtils.resultSetToTableModel(rs));
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
                
                    
                public void pesquisar_produtos_por_id(){
//         

          try{
                String sql = "select * from tb_produtos where id = ?";
              
//              
               
                int IDProd = Integer.valueOf(IdProduto.getText());
                
//                System.out.println(IDProd);   

              
               pst=conexao.prepareStatement(sql);
           
                pst.setInt(1, IDProd);

               
                rs= pst.executeQuery();
                     
                     
                     while(rs.next()){
                         
                     String estoque = Integer.toString(rs.getInt("qtd_estoque"));
                                               
                    String preco = Integer.toString(rs.getInt("preco"));


                         
                          NomeProduto.setText(rs.getString("nome")); 
                          Estoque.setText(estoque);
                           Preco.setText(preco);
                     }
                     
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
    
                  public void setar_campos(){
            int setar = TabelaProdutos.getSelectedRow();
            
               IdProduto.setText(TabelaProdutos.getModel().getValueAt(setar, 0).toString());  
               NomeProduto.setText(TabelaProdutos.getModel().getValueAt(setar, 1).toString()); 
//                Descricao.setText(TabelaProdutos.getModel().getValueAt(setar, 2).toString());   
               Preco.setText(TabelaProdutos.getModel().getValueAt(setar, 3).toString());
               Estoque.setText(TabelaProdutos.getModel().getValueAt(setar, 4).toString());     
//               ForId.setText(Tabela.getModel().getValueAt(setar, 5).toString());
             


//               AddButton.setEnabled(false);

        }
                  
                  
                public void pesquisar_produtos_por_nome(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                    String sql = "select * from tb_produtos where  nome like ?";

          try{
               pst=conexao.prepareStatement(sql);
               
               pst.setString(1, PesquisaProduto.getText() + "%");
               
                     rs= pst.executeQuery();
                     
                     TabelaProdutos.setModel(DbUtils.resultSetToTableModel(rs));
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          
           
      }
    
    
         
                public void pesquisar_clientes_por_cpf(){
//          String sql = "select  id as Id, name as Nome, email as Email, fone as Telefone, endereco as Endereço  from clientes where  name like ?";
                    String sql = "select * from tb_clientes where  cpf like ?";

          try{
               pst=conexao.prepareStatement(sql);
               
//               pst.setString(1, CPF.getText()); 
               pst.setString(1, CPF.getText());

               
                     rs= pst.executeQuery();
                     
                     if(rs.next()){
                     Nome.setText(rs.getString("nome"));
                        
                     }
                     
                     
                     
//                     TabelaProdutos.setModel(DbUtils.resultSetToTableModel(rs));
          
              }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PesquisaProduto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        Data = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        IdProduto = new javax.swing.JTextField();
        NomeProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Preco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Estoque = new javax.swing.JTextField();
        QTD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SalvarButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        desconto = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Carrinho = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        PagamentoButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ponto de Vendas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(19, 7, 7));
        jPanel1.setForeground(new java.awt.Color(234, 225, 225));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(233, 219, 219));
        jLabel1.setText("Ponto de Vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(535, 535, 535)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jLabel2.setText("CPF");

        CPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPFKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CPFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CPFKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("Pesquise um produto aqui");

        PesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PesquisaProdutoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PesquisaProdutoKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Data");

        TabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Descrição", "Quantidade Estoque", "Preço", "Fornecedor"
            }
        ));
        TabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabelaProdutosMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaProdutos);

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel13.setText("Digite o CPF nesse formato: 111.111.111-11");

        Data.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Data))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jLabel6.setText("Código");

        IdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdProdutoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdProdutoKeyPressed(evt);
            }
        });

        jLabel7.setText("Produto");

        jLabel8.setText("Preço");

        jLabel9.setText("Estoque");

        QTD.setText("1");

        jLabel10.setText("QTD");

        SalvarButton.setText("ADD ITEM");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Desconto %");

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QTD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(SalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(IdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(desconto))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(QTD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SalvarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(89, 89, 89))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho de compras"));

        Carrinho.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Carrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "produto", "qtd", "preço", "subtotal"
            }
        ));
        Carrinho.setRowHeight(24);
        jScrollPane2.setViewportView(Carrinho);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Total da Venda"));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel12.setText("Total da Venda");

        Total.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        PagamentoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pay-40.png"))); // NOI18N
        PagamentoButton.setText("PAGAMENTO");

        CancelarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar-30.png"))); // NOI18N
        CancelarButton.setText("Cancelar Venda");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(140, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PagamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(CancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PagamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFKeyReleased
        // TODO add your handling code here:

        pesquisar_clientes_por_cpf();
    }//GEN-LAST:event_CPFKeyReleased

    private void CPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){

            pesquisar_clientes_por_cpf();

        }

    }//GEN-LAST:event_CPFKeyPressed

    private void CPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFKeyTyped
        // TODO add your handling code here:
//                         pesquisar_clientes_por_cpf();
    }//GEN-LAST:event_CPFKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                    pesquisar_clientes_por_cpf();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
         pesquisar_produtos();
        Date agora = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy  |  HH:mm:ss"); 
        String DataFormatada = formato.format(agora);
        
      Data.setText("  " + DataFormatada);
        
        
    }//GEN-LAST:event_formWindowActivated

    private void TabelaProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProdutosMousePressed
        // TODO add your handling code here:
        
//        setar_campos();
        
    }//GEN-LAST:event_TabelaProdutosMousePressed

    private void IdProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdProdutoKeyPressed
        // TODO add your handling code here:
        
//         pesquisar_produtos_por_id();
    }//GEN-LAST:event_IdProdutoKeyPressed

    private void IdProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdProdutoKeyTyped
        // TODO add your handling code here:
        
//        pesquisar_produtos_por_id();
    }//GEN-LAST:event_IdProdutoKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pesquisar_produtos_por_id();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        IdProduto.setText("");
        NomeProduto.setText("");
        Preco.setText("");
        Estoque.setText("");
        QTD.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PesquisaProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisaProdutoKeyTyped
        // TODO add your handling code here:
//        pesquisar_produtos_por_nome();
    }//GEN-LAST:event_PesquisaProdutoKeyTyped

    private void PesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisaProdutoKeyPressed
        // TODO add your handling code here:
                pesquisar_produtos_por_nome();

    }//GEN-LAST:event_PesquisaProdutoKeyPressed

    private void TabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProdutosMouseClicked
        // TODO add your handling code here:
                setar_campos();
                
                  IdProduto.setEnabled(false);
        NomeProduto.setEnabled(false);
        Preco.setEnabled(false);
        Estoque.setEnabled(false);
//                IdProduto.setEnabled(false);
    }//GEN-LAST:event_TabelaProdutosMouseClicked

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        // TODO add your handling code here:
        
        if(NomeProduto.getText() != null ){
            int estoque = Integer.valueOf(Estoque.getText());
            int quantidade = Integer.valueOf(QTD.getText());
            
            preco = Double.valueOf(Preco.getText());
            int qtd = Integer.valueOf(QTD.getText());
            subtotal = preco*qtd;
            
            total += subtotal;
            
            if(estoque >= quantidade){
                Total.setText(String.valueOf(total));
                meus_produtos = (DefaultTableModel)Carrinho.getModel();
                
                meus_produtos.addRow(new Object[] {
                  IdProduto.getText(),
                  NomeProduto.getText(),
                  QTD.getText(),
                  Preco.getText(),
                  subtotal
                });
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Quantidade maior que o estoque!!");
            }


        }
//        else{
//                JOptionPane.showMessageDialog(null, "Erro no carrinho faltam dados do produto !!");
//            }
    }//GEN-LAST:event_SalvarButtonActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPF;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JTable Carrinho;
    private javax.swing.JTextField Data;
    private javax.swing.JTextField Estoque;
    private javax.swing.JTextField IdProduto;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField NomeProduto;
    private javax.swing.JButton PagamentoButton;
    private javax.swing.JTextField PesquisaProduto;
    private javax.swing.JTextField Preco;
    private javax.swing.JTextField QTD;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JTable TabelaProdutos;
    private javax.swing.JTextField Total;
    private javax.swing.JTextField desconto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
