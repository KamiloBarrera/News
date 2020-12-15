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

package cl.ucn.disc.dsm.cbarrera.mynews.model;

import net.openhft.hashing.LongHashFunction;

import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.cbarrera.mynews.util.Validation;

/**
 * The domain model: News
 * @author Camilo Barrera A., camilo.barrera@alumnos.ucn.cl
 */
public final class News {
    /**
     * Unique id.
     */
    private final Long id;
    /**
     * The title.
     */
    private final String title;
    /**
     * Source of the news.
     */
    private final String source;
    /**
     * The author
     */
    private final String author;
    /**
     * The URL
     */
    private final String url;
    /**
     * The URL of the image
     */
    private final String urlImage;
    /**
     * The description
     */
    private final String description;
    /**
     * The content
     */
    private final String content;
    /**
     * The Date of publish
     */
    private final ZonedDateTime publishedAt;

    /**
     * The constructor
     * @param title     can't be null.
     * @param source    can't be null.
     * @param author    can't be null.
     * @param url       to the main article.
     * @param urlImage  to the image
     * @param description   -full article
     * @param content   can't be null.
     * @param publishedAt   can't be null.
     */
    public News(String title, String source, String author, String url, String urlImage, String description, String content, ZonedDateTime publishedAt) {
        //Validation of Title
        Validation.minSize(title,2,"title");
        this.title = title;

        //Validation of Source
        Validation.minSize(source,2,"source");
        this.source = source;

        //Validation of Author
        Validation.minSize(author,2,"author");
        this.author = author;

        //Apply hash function
        this.id = LongHashFunction.xx().hashChars(title +"|" +source +"|"+ author);


        this.url = url;
        this.urlImage = urlImage;

        Validation.minSize(description,10,"description");
        this.description = description;

        Validation.notNull(content,"Content");
        this.content = content;

        Validation.notNull(publishedAt,"PublishedAt");
        this.publishedAt = publishedAt;
    }

    /**
     * Get the Id of the news.
     * @return Id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the title of the news.
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the source of the news.
     * @return source.
     */
    public String getSource() {
        return source;
    }

    /**
     * Get the author of the news.
     * @return author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the URL of the news.
     * @return URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get the Image URL of the news.
     * @return Image URL.
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * Get the description of the news.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the Content of the news.
     * @return content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Get the date of publication of the news
     * @return Date of publication
     */
    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }
}
