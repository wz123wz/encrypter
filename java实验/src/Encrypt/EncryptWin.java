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
 * ���ӻ����ڽ��� <����>
 * 
 * @author ��ƽ ����� �غ��� ��Ǫ ����Ƽ ����
 * @version [�汾��, Dec 8, 2018]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class EncryptWin
{
    private static SecretKey K;// AES�㷨�洢ԭʼ��Կ
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("���ܽ�����");
        frame.setLocation(600, 200);
        ImageIcon imageIcon = new ImageIcon("1.jpg");
        frame.setIconImage(imageIcon.getImage());// ��ͼ��
        // JMenuBar����
        JMenuBar jmb = new JMenuBar();
        // JMenu����
        JMenu menu1;
        menu1 = new JMenu("����");
        
        // Button����
        JButton button1 = new JButton("��������");
        JButton button2 = new JButton("��������");
        JButton button3 = new JButton("AES����");
        JButton button4 = new JButton("AES����");
        
        // JTextField����
        final JTextField content = new JTextField();
        final JTextField pass = new JTextField();
        final JTextField dpass = new JTextField();
        final JTextField pass1 = new JTextField();
        final JTextField dpass1 = new JTextField();
        
        // JLabel
        JLabel view = new JLabel("����", JLabel.CENTER);
        view.setFont(new java.awt.Font("����", 1, 15));
        view.setOpaque(true);
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        
        // �˵�����
        jmb.add(menu1);
        
        frame.setJMenuBar(jmb);
        // ��������
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
        
        // ��С����
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
        
        // ����¼�����ȫ��Ϊ�����ڲ��ദ��ʽʵ��
        
        
        
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
                JOptionPane.showMessageDialog(null, "��ƽ ����� �غ��� ��Ǫ ����Ƽ ����");
                
            }
        });
        
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO ��������
                int key = 3;// ����������ܣ������λ3λ
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
                // TODO ��������
                int key = -3;// ����������ܣ���ǰ��λ3λ
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
                // AES����
                
                String str = content.getText().toString();
                try
                {
                    // 1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
                    KeyGenerator keygen = KeyGenerator.getInstance("AES");
                    // 2.����ecnodeRules�����ʼ����Կ������
                    // ����һ��128λ�����Դ
                    keygen.init(128);
                    // 3.����ԭʼ�Գ���Կ
                    SecretKey original_key = keygen.generateKey();
                    K = original_key;// �洢�ھ�̬�����У�����Ҫ��
                    // 4.���ԭʼ�Գ���Կ���ֽ�����
                    byte[] raw = original_key.getEncoded();
                    // 5.�����ֽ���������AES��Կ
                    SecretKey key = new SecretKeySpec(raw, "AES");
                    // 6.����ָ���㷨AES�Գ�������
                    Cipher cipher = Cipher.getInstance("AES");
                    // 7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽��ܽ���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    // 8.��ȡ�������ݵ��ֽ�����(����Ҫ����Ϊutf-8)��Ȼ��������������ĺ�Ӣ�Ļ�����ľͻ����Ϊ����
                    byte[] byte_encode = str.getBytes("utf-8");
                    // 9.�����������ĳ�ʼ����ʽ--���ܣ������ݼ���
                    byte[] byte_AES = cipher.doFinal(byte_encode);
                    // 10.�����ܺ������ת��Ϊ�ַ���
                    
                    String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
                    // 11.���ַ�������
                    
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
                
                // AES�ӽ���
                // String encodeRules;
                String str = pass1.getText().toString();
                ;
                try
                {
                    // 1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
                    KeyGenerator keygen = KeyGenerator.getInstance("AES");
                    // 2.����K��ʼ����Կ������
                    // ����һ��128λ�����Դ
                    keygen.init(128);
                    // 3.����ԭʼ�Գ���Կ
                    SecretKey original_key = K;
                    // 4.���ԭʼ�Գ���Կ���ֽ�����
                    byte[] raw = original_key.getEncoded();
                    // 5.�����ֽ���������AES��Կ
                    SecretKey key = new SecretKeySpec(raw, "AES");
                    // 6.����ָ���㷨AES�Գ�������
                    Cipher cipher = Cipher.getInstance("AES");
                    // 7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    // 8.�����ܲ����������ݽ�����ֽ�����
                    byte[] byte_content = new BASE64Decoder().decodeBuffer(str);
                    /*
                     * ����
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
