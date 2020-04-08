package hw4.pages.builder;

import java.util.List;

public class TestData {

    private List<String> summary;
    private List<String> elements;
    private List<String> colors;
    private List<String> metals;
    private List<String> vegetables;

    private TestData(List<String> summary, List<String> elements, List<String> colors,
                              List<String> metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<String> getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<String> summary;
        private List<String> elements;
        private List<String> colors;
        private List<String> metals;
        private List<String> vegetables;

        private TestData testData;

        public Builder() {
        }

        public Builder setSummary(List<String> summary) {
            this.summary = summary;
            return this;
        }

        public Builder setElements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Builder setColors(List<String> colors) {
            this.colors = colors;
            return this;
        }

        public Builder setMetals(List<String> metals) {
            this.metals = metals;
            return this;
        }

        public Builder setVegetables(List<String> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public TestData build() {
            return new TestData(summary, elements, colors, metals, vegetables);
        }
    }
}
