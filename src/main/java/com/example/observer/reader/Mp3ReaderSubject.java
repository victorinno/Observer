package com.example.observer.reader;

import com.example.observer.events.Event;
import com.example.observer.observer.Subject;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;

public class Mp3ReaderSubject extends Subject<Event> implements Reader {
    @Override
    public void read(Event event) {
        try {
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream(event.getFrom());
            ParseContext pcontext = new ParseContext();
            Mp3Parser Mp3Parser = new Mp3Parser();
            Mp3Parser.parse(inputstream, handler, metadata, pcontext);
            event.setMetadata(metadata);
            notifyObservers(event);
        } catch (TikaException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


}
