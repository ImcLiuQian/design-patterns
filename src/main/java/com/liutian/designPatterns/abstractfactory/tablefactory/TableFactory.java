package com.liutian.designPatterns.abstractfactory.tablefactory;

import com.liutian.designPatterns.abstractfactory.factory.Factory;
import com.liutian.designPatterns.abstractfactory.factory.Link;
import com.liutian.designPatterns.abstractfactory.factory.Page;
import com.liutian.designPatterns.abstractfactory.factory.Tray;

public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
