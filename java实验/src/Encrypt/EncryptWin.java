package Encrypt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//import com.sun.prism.Image;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
//import sun.security.provider.SecureRandom;
import javax.swing.JOptionPane;
//import java.util.Random;

/**
 * 
 * 可视化窗口界面 <窗口>
 * 
 * @author 杨平 陈雨蝉 秦浩宇 陶仟 郭鑫萍 王智
 * @version [版本号, Dec 8, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class EncryptWin
{
    private static SecretKey K;// AES算法存储原始密钥
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("加密解密器");
        frame.setLocation(600, 200);
        ImageIcon imageIcon = new ImageIcon("1.jpg");
        frame.setIconImage(imageIcon.getImage());// 改图标
        // JMenuBar名称
        JMenuBar jmb = new JMenuBar();
        // JMenu名称
        JMenu menu1;
        menu1 = new JMenu("关于");
        
        // Button名称
        JButton button1 = new JButton("凯撒加密");
        JButton button2 = new JButton("凯撒解密");
        JButton button3 = new JButton("AES加密");
        JButton button4 = new JButton("AES解密");
        
        // JTextField名称
        final JTextField content = new JTextField();
        final JTextField pass = new JTextField();
        final JTextField dpass = new JTextField();
        final JTextField pass1 = new JTextField();
        final JTextField dpass1 = new JTextField();
        
        // JLabel
        JLabel view = new JLabel("明文", JLabel.CENTER);
        view.setFont(new java.awt.Font("明文", 1, 15));
        view.setOpaque(true);
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        
        // 菜单布局
        jmb.add(menu1);
        
        frame.setJMenuBar(jmb);
        // 画布布局
        JPanel contentPane = new JPanel();
        // contentPane.setBackground(Color.gray);
        
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        
        contentPane.add(content);
        contentPane.add(pass);
        contentPane.add(dpass);
        contentPane.add(pass1);
        contentPane.add(dpass1);
        contentPane.add(view);
        
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // 大小设置
        view.setBounds(250, 70, 120, 30);
        content.setBounds(50, 70, 200, 30);
        pass.setBounds(50, 120, 200, 30);
        button1.setBounds(250, 120, 120, 30);
        dpass.setBounds(50, 170, 200, 30);
        button2.setBounds(250, 170, 120, 30);
        pass1.setBounds(50, 220, 200, 30);
        button3.setBounds(250, 220, 120, 30);
        dpass1.setBounds(50, 270, 200, 30);
        button4.setBounds(250, 270, 120, 30);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
        // 添加事件处理，全部为匿名内部类处理方式实现
        
        
        
        menu1.addMenuListener(new MenuListener()
        {
            @Override
            public void menuDeselected(MenuEvent e)
            {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void menuCanceled(MenuEvent e)
            {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void menuSelected(MenuEvent e)
            {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "杨平 陈雨婵 秦浩宇 陶仟 郭鑫萍 王智");
                
            }
        });
        
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO 凯撒加密
                int key = 3;// 凯撒密码加密，向后移位3位
                String encrypt_str = "";
                String str = content.getText().toString();
                for (int i = 0; i < str.length(); i++)
                {
                    char c = str.charAt(i);
                    if (c >= 'a' && c <= 'z')
                    {
                        if (c >= 'x' && c <= 'z')
                        {
                            c -= 26;
                            c += key;
                        }
                        else
                        {
                            c += key;
                        }
                    }
                    else if (c >= 'A' && c <= 'Z')
                    {
                        if (c >= 'X' && c <= 'Z')
                        {
                            c -= 26;
                            c += key;
                        }
                        else
                        {
                            c += key;
                        }
                    }
                    encrypt_str += c;
                }
                pass.setText(encrypt_str);
            }});
        button2.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO 凯撒解密
                int key = -3;// 凯撒密码解密，向前移位3位
                String decrypt_str = "";
                String str2 = pass.getText().toString();
                for (int i = 0; i < str2.length(); i++)
                {
                    char c = str2.charAt(i);
                    if (c >= 'a' && c <= 'z')
                    {
                        if (c >= 'a' && c <= 'c')
                        {
                            c += 26;
                            c += key;
                        }
                        else
                        {
                            c += key;
                        }
                    }
                    else if (c >= 'A' && c <= 'Z')
                    {
                        if (c >= 'A' && c <= 'C')
                        {
                            c += 26;
                            c += key;
                        }
                        else
                        {
                            c += key;
                        }
                    }
                    decrypt_str += c;
                }
                dpass.setText(decrypt_str);
            }
            
        });
        
        button3.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // AES加密
                
                String str = content.getText().toString();
                try
                {
                    // 1.构造密钥生成器，指定为AES算法,不区分大小写
                    KeyGenerator keygen = KeyGenerator.getInstance("AES");
                    // 2.根据ecnodeRules规则初始化密钥生成器
                    // 生成一个128位的随机源
                    keygen.init(128);
                    // 3.产生原始对称密钥
                    SecretKey original_key = keygen.generateKey();
                    K = original_key;// 存储于静态变量中，解密要用
                    // 4.获得原始对称密钥的字节数组
                    byte[] raw = original_key.getEncoded();
                    // 5.根据字节数组生成AES密钥
                    SecretKey key = new SecretKeySpec(raw, "AES");
                    // 6.根据指定算法AES自成密码器
                    Cipher cipher = Cipher.getInstance("AES");
                    // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    // 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
                    byte[] byte_encode = str.getBytes("utf-8");
                    // 9.根据密码器的初始化方式--加密：将数据加密
                    byte[] byte_AES = cipher.doFinal(byte_encode);
                    // 10.将加密后的数据转换为字符串
                    
                    String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
                    // 11.将字符串返回
                    
                    pass1.setText(AES_encode);
                }
                catch (NoSuchAlgorithmException e)
                {
                    e.printStackTrace();
                }
                catch (NoSuchPaddingException e)
                {
                    e.printStackTrace();
                }
                catch (InvalidKeyException e)
                {
                    e.printStackTrace();
                }
                catch (IllegalBlockSizeException e)
                {
                    e.printStackTrace();
                }
                catch (BadPaddingException e)
                {
                    e.printStackTrace();
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
                
            }
        });
        
        button4.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                
                // AES加解密
                // String encodeRules;
                String str = pass1.getText().toString();
                ;
                try
                {
                    // 1.构造密钥生成器，指定为AES算法,不区分大小写
                    KeyGenerator keygen = KeyGenerator.getInstance("AES");
                    // 2.根据K初始化密钥生成器
                    // 生成一个128位的随机源
                    keygen.init(128);
                    // 3.产生原始对称密钥
                    SecretKey original_key = K;
                    // 4.获得原始对称密钥的字节数组
                    byte[] raw = original_key.getEncoded();
                    // 5.根据字节数组生成AES密钥
                    SecretKey key = new SecretKeySpec(raw, "AES");
                    // 6.根据指定算法AES自成密码器
                    Cipher cipher = Cipher.getInstance("AES");
                    // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    // 8.将加密并编码后的内容解码成字节数组
                    byte[] byte_content = new BASE64Decoder().decodeBuffer(str);
                    /*
                     * 解密
                     */
                    byte[] byte_decode = cipher.doFinal(byte_content);
                    String AES_decode = new String(byte_decode, "utf-8");
                    
                    dpass1.setText(AES_decode);
                }
                catch (NoSuchAlgorithmException e)
                {
                    e.printStackTrace();
                }
                catch (NoSuchPaddingException e)
                {
                    e.printStackTrace();
                }
                catch (InvalidKeyException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                catch (IllegalBlockSizeException e)
                {
                    e.printStackTrace();
                }
                catch (BadPaddingException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
    }
    
}
