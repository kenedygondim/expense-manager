package com.kenedygondim.expense_manager.service;

import com.kenedygondim.expense_manager.model.ExpenseRegister;
import com.kenedygondim.expense_manager.repository.ExpenseManagerRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class XmlConverterService {
    private final ExpenseManagerRepository expenseManagerRepository;
    @Autowired
    public XmlConverterService(ExpenseManagerRepository expenseManagerRepository) {
        this.expenseManagerRepository = expenseManagerRepository;
    }
    public ExpenseRegister convertXmlToObject (MultipartFile xmlFile) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            File fileConverted = convertMultipartToFile(xmlFile);

            Document doc = docBuilder.parse(fileConverted);
            doc.getDocumentElement().normalize();
            Element infNFe = (Element) doc.getElementsByTagName("infNFe").item(0);
            //INFO NF
            Element ide = getElement(infNFe, "ide");
            String ideDataEmissaoNf = getElementValueString(ide,"dhEmi");
            ///EMITENTE NF
            Element emit = getElement(infNFe,"emit");
            String emitCNPJ = getElementValueString(emit, "CNPJ");
            String emitNome =  getElementValueString(emit, "xNome");
            Element det = getElement(infNFe,"det");
            //PRODUTO
            Element detProd = getElement(det, "prod");
            String detProdNome = getElementValueString(detProd, "xProd");
            Double detProdValor = getElementValueDouble(detProd, "vProd");
            Double detProdDesc = getElementValueDouble(detProd, "vDesc");
            Integer detProdQuantidade = (int) getElementValueDouble(detProd, "qCom");
            //IMPOSTO
            Element detImposto = getElement(det, "imposto");
            Double detImpostoTotalTributos = getElementValueDouble(detImposto, "vTotTrib");
            //Transportadora
            Element transp = getElement(infNFe,"transp");
            Element transpTransporta = getElement(transp, "transporta");
            String transpTransportaNome = getElementValueString(transpTransporta, "xNome");
            ExpenseRegister expenseRegister = new ExpenseRegister();
            expenseRegister.setCnpjEmitenteNf(emitCNPJ);
            expenseRegister.setDataEmissaoNf(ideDataEmissaoNf);
            expenseRegister.setNomeEmitenteNf(emitNome);
            expenseRegister.setNomeProduto(detProdNome);
            expenseRegister.setValorProduto(detProdValor);
            expenseRegister.setValorDescontos(detProdDesc);
            expenseRegister.setQuantidade(detProdQuantidade);
            expenseRegister.setValorImpostos(detImpostoTotalTributos);
            expenseRegister.setNomeTransportadora(transpTransportaNome);

            fileConverted.delete();

            return expenseManagerRepository.save(expenseRegister);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private File convertMultipartToFile (MultipartFile xmlFile){
            try {
                File convertedFile = new File(xmlFile.getOriginalFilename());
                FileOutputStream fos = new FileOutputStream(convertedFile);
                fos.write(xmlFile.getBytes());
                fos.close();
                return convertedFile;
            } catch (IOException | NullPointerException ex) {
                ex.printStackTrace();
            }
        return null;
    }
    private static Element getElement (Element parent, String tagName) {
        if (parent != null) {
            NodeList nodeList = parent.getElementsByTagName(tagName);
            if (nodeList.getLength() > 0)
                return (Element) nodeList.item(0);
        }
        return null;
    }
    private static String getElementValueString (Element element, String tagName) {
        Element childElement= getElement(element, tagName);
        return (childElement != null) ? childElement.getTextContent() : "N/A";
    }

    private static double getElementValueDouble (Element element, String tagName){
        Element childElement= getElement(element, tagName);
        return (childElement != null) ? Double.parseDouble(childElement.getTextContent()) : 0.0;
    }
}

