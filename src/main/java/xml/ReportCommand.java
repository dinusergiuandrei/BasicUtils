package xml;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReportCommand {
//
//    public void writeAsXml(String path) throws XMLStreamException, IOException {
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
//            XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);
//            writer.writeStartDocument();
//            writer.writeStartElement("catalog");
//
//            this.catalog.getDocuments().forEach(
//                    document -> {
//                        try {
//                            writer.writeStartElement(document.getClass().getName());
//
//                            {
//                                writer.writeStartElement("title");
//                                writer.writeCharacters(document.getTitle());
//                                writer.writeEndElement();
//
//
//                                writer.writeStartElement("path");
//                                writer.writeCharacters(document.getPath());
//                                writer.writeEndElement();
//
//
//                                writer.writeStartElement("year");
//                                writer.writeCharacters(document.getYear().toString());
//                                writer.writeEndElement();
//
//                                writer.writeStartElement("authors");
//                                document.getAuthors().forEach(
//                                        author -> {
//                                            try {
//                                                writer.writeStartElement("author");
//                                                writer.writeCharacters(author);
//                                                writer.writeEndElement();
//                                            } catch (XMLStreamException e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                );
//                                writer.writeEndElement();
//                            }
//
//                            writer.writeEndElement();
//                        } catch (XMLStreamException e) {
//                            e.printStackTrace();
//                        }
//                    }
//            );
//
//            writer.writeEndElement();
//        }
//    }

}
