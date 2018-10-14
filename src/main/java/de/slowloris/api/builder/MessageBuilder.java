/*
 *     Copyright (c) 2018 Slowloris.de
 *     Development: Weichtier
 *
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!
 */

package de.slowloris.api.builder;

import net.md_5.bungee.api.chat.*;

public class MessageBuilder {

    private BaseComponent component;

    public MessageBuilder(String message){
        component = new TextComponent(message);
    }

    public void setClickEvent(ClickEvent.Action action, String value){
        component.setClickEvent(new ClickEvent(action, value));
    }

    public void setHoverEvent(HoverEvent.Action action, String value){
        component.setHoverEvent(new HoverEvent(action, new ComponentBuilder(value).create()));
    }

    public BaseComponent build() {
        return component;
    }
}
