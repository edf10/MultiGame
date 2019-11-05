package imagens;

import javax.swing.ImageIcon;

public class Im {
    private ImageIcon imagem;
    
    public ImageIcon addImagem(String nameArquivo){
        imagem = new ImageIcon(getClass().getResource("imagens/"+nameArquivo+".png"));
        return imagem;
    }
    public ImageIcon addGif(String nameArquivo){
        imagem = new ImageIcon(getClass().getResource("imagens/"+nameArquivo+".gif"));
        return imagem;
    }
    
}
