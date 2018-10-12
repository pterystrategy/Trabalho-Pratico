package br.com.prodrigues.trabalhopratico.view.html;

import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.util.List;

/**
 *
 * @author alessiojr
 */
public class ClienteHtml {
    
    private static String cabecalho = 
        "<!DOCTYPE html>\n" +
        "<html>\n" +
        "    <head>\n" +
        "        <title>{{Titulodorelatorio}}</title>\n" +
        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n" +
        "        <style type=\"text/css\">\n" +
        "            @page{\n" +
        "                margin-top: 3cm;\n" +
        "                margin-left: 3cm;\n" +
        "                margin-bottom: 2cm;\n" +
        "                margin-left: 2cm;\n" +
        "            }\n" +
        "            #titulo{\n" +
        "                font-size: 14px;\n" +
        "                text-align: center;\n" +
        "            }\n" +
        "            #tabela{\n" +
        "                width: 90%;\n" +
        "                font-size: 12px;\n" +
        "                margin: 0 auto;\n" +
        "                text-align: justify;\n" +
        "                border: 1px solid black;\n" +
        "                border-collapse: collapse;\n" +
        "                white-space: pre-line;\n" +
        "                table-layout: auto;\n" +
        "                width: content-box;\n" +
        "				height: content-box;\n" +
        "            }\n" +
        "            .celula{\n" +
        "                border: 1px solid black;\n" +
        "                text-align: justify;\n" +
        "                font-size: 12px;\n" +
        "            }\n" +
        "            .celula_center{\n" +
        "                border: 1px solid black;\n" +
        "                text-align: center;\n" +
        "                font-size: 12px;\n" +
        "			}\n" +
        "            .celula_head{\n" +
        "                border: 2px solid black;\n" +
        "                background-color: #D3D3D3;\n" +
        "                text-align: center;\n" +
        "                font-size: 12px;\n" +
        "            }\n" +
        "            #rodape-final{\n" +
        "                width: 100%;\n" +
        "                position: absolute;\n" +
        "                top: 22cm;\n" +
        "                left: 0cm;\n" +
        "                bottom: 3cm;\n" +
        "                right: 2cm;\n" +
        "                font-size: 12px;\n" +
        "            }\n" +
        "            #align-right{\n" +
        "                text-align: right;\n" +
        "            }\n" +
        "        </style>\n" +
        "    </head><body>\n";

    private static String rodape = 
        "        <div id=\"rodape-final\">\n" +
        "            <hr size=\"1\" color=black>\n" +
        "            <p id=\"align-right\"><b>TOTAL DE ESTADOS: </b>{{TOTAL_GERAL}}</p>\n" +
        "        </div>\n" +
        "    </body>\n" +
        "</html>\n";

    private static String inicio = 
        "        <div>\n" +
        "            <p id=\"titulo\"><b>{{NOME_DA_EMPRESA}}</b></p>\n" +
        "            <p><b>Cliente: </b>{{NOME_DO_CLIENTE}}.</p>\n" +
        "        </div>\n";
    
    private static String tabela = 
        "        <table id=\"tabela\">\n" +
        "            <thead>\n" +
        "                <tr>\n" +
        "                    <th class=\"celula_head\">Cod</th>\n" +
        "                    <th class=\"celula_head\">Nome</th>\n" +
        "                    <th class=\"celula_head\">UF</th>\n" +
        "                    <th class=\"celula_head\">Capital</th>\n" +
        "                </tr>\n" +
        "            </thead>\n" +
        "            <tbody>\n" +
        "                {{conteudotabela}}\n" +
        "            </tbody>\n" +
        "        </table>\n";

    private static String conteudotabela = 
        "                <tr>\n" +
        "                	<td class=\"celula_center\">{{COD}}</td>\n" +
        "                    <td class=\"celula_center\">{{NOME}}</td>\n" +
        "                    <td class=\"celula_center\">{{UF}}</td>\n" +
        "                    <td class=\"celula\">{{CAPITAL}}</td>\n" +
        "                </tr>\n";
            
    
    public static String gerarRelatorio(List<Cliente> lista, String titulo){
        String retorno;
        retorno = cabecalho.replace("{{Titulodorelatorio}}", titulo);
        retorno += inicio;
        
        String conteudo = "";
        for (Cliente cliente : lista) {
            conteudo += conteudotabela;
            conteudo = conteudo.replace("{{COD}}", cliente.getId().toString());
            conteudo = conteudo.replace("{{NOME}}", cliente.getName());
            conteudo = conteudo.replace("{{UF}}", cliente.getCpf());
            conteudo = conteudo.replace("{{CAPITAL}}", "sss");            
        }
        
        retorno += tabela.replace("{{conteudotabela}}", conteudo);        
        retorno += rodape.replace("{{TOTAL_GERAL}}", String.valueOf(lista.size()));
        return retorno;
    }
    
}

