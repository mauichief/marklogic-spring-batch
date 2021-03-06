package com.marklogic.spring.batch.item;

import java.util.List;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;

import org.w3c.dom.Document;

import org.springframework.batch.item.ItemWriter;

public class DocumentItemWriter implements ItemWriter<Document> {

	private DatabaseClient client;

	public DocumentItemWriter(DatabaseClient databaseClient) {
		this.client = databaseClient;
	}
	
	@Override
	public void write(List<? extends Document> items) throws Exception {
		XMLDocumentManager docMgr = client.newXMLDocumentManager();
		for (Document doc : items) {
			DOMHandle handle = new DOMHandle(doc);
			docMgr.write(doc.getDocumentURI(), handle);
		}		
	}

}
