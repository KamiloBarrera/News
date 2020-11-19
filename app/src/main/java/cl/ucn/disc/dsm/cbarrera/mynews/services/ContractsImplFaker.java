/*
 * Copyright(c)
 *
 * Copyright 2020 Camilo Barrera Arancibia, camilo.barrera@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.cbarrera.mynews.services;

import com.github.javafaker.Faker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.cbarrera.mynews.model.News;

/**
 * The faker implementation of {@link Contracts}
 *
 * @author Camilo Barrera A., camilo.barrera@alumnos.ucn.cl
 */
public final class ContractsImplFaker implements Contracts{
    /**
     * The logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ContractsImplFaker.class);
    /**
     * The list of News.
     */
    private final List<News> theNews = new ArrayList<>();

    /**
     * The Contructor: Generate 5 {@link News}
     */
    public ContractsImplFaker() {
        // The faker to use
        final Faker faker = Faker.instance();

        for(int i = 0;i < 5;i++){
            this.theNews.add(new News(
                    Integer.toUnsignedLong(i),
                    faker.book().title(),
                    faker.name().username(),
                    faker.name().fullName(),
                    faker.internet().url(),
                    faker.internet().avatar(),
                    faker.harryPotter().quote(),
                    faker.lorem().paragraph(3),
                    ZonedDateTime.now(ZoneId.of("-3"))
            ));
        }
    }

    /**
     * Get the list of News.
     * @param size size of the list.
     * @return the List of News.
     */
    @Override
    public List<News> retrieveNews(Integer size) {
        // The last "size" elements.
        if(size > theNews.size()){
            size = theNews.size();
        }
        return theNews.subList(theNews.size()-size,theNews.size());
    }

    /**
     * Save one News into the System.
     *
     * @param news to save
     */
    @Override
    public void saveNews(News news) {
        // FIXME: Don't allow duplicated !!

        if(news == null){
            throw new IllegalArgumentException();
        }
        this.theNews.add(news);
    }
}
