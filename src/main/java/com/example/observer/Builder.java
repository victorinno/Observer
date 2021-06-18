package com.example.observer;

public class Builder {
    InnerBuilder atual = new InnerBuilder();
    InnerBuilder anterior = null;

    public Builder next() {
        InnerBuilder builder = new InnerBuilder();
        this.anterior = atual;
        this.atual = builder;
        return this;
    }

    public Builder back() {
        Object build = atual.build();
        anterior.add(build);
        atual = anterior;
        anterior = null;
        return this;
    }

    public Object build() {
        return atual.build();
    }

    class InnerBuilder {
        public void add(Object o) {

        }

        public Object build() {
            return null;
        }
    }
}
