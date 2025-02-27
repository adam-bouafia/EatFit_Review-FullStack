package it.univaq.disim.sose.search.model;

import org.json.JSONObject;

/**
 * This class represents a search result for a food item, including its ID, label,
 * category, image, brand, and nutritional information.
 */
public class Result {
    private String id;
    private String label;
    private String category;
    private String categoryLabel;
    private String image;
    private String brand;
    private Nutrients nutrients;

    /**
     * Default constructor.
     */
    public Result() {
    }

    /**
     * Parameterized constructor to initialize all fields.
     *
     * @param id             The ID of the food item.
     * @param label          The label (name) of the food item.
     * @param category       The category of the food item.
     * @param categoryLabel  The label for the category.
     * @param image          The URL of the image representing the food item.
     * @param brand          The brand of the food item.
     * @param nutrients      The nutritional information of the food item.
     */
    public Result(String id, String label, String category, String categoryLabel, String image, String brand, Nutrients nutrients) {
        this.id = id;
        this.label = label;
        this.category = category;
        this.categoryLabel = categoryLabel;
        this.image = image;
        this.brand = brand;
        this.nutrients = nutrients;
    }

    // Getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(JSONObject nutrientsObject) {
        this.nutrients = new Nutrients(nutrientsObject);
    }

    /**
     * Inner class representing the nutritional information of the food item.
     */
    public static class Nutrients {
        private Double ENERC_KCAL; // Energy in kcal
        private Double PROCNT; // Protein in g
        private Double FAT; // Total lipid (fat) in g
        private Double CHOCDF; // Carbohydrate, by difference in g
        private Double FIBTG; // Fiber, total dietary in g

        /**
         * Default constructor.
         */
        public Nutrients() {
        }

        /**
         * Constructor to initialize Nutrients from a JSONObject.
         *
         * @param nutrientsObject The JSON object containing nutritional information.
         */
        public Nutrients(JSONObject nutrientsObject) {
            this.ENERC_KCAL = nutrientsObject.optDouble("ENERC_KCAL", 0);
            this.PROCNT = nutrientsObject.optDouble("PROCNT", 0);
            this.FAT = nutrientsObject.optDouble("FAT", 0);
            this.CHOCDF = nutrientsObject.optDouble("CHOCDF", 0);
            this.FIBTG = nutrientsObject.optDouble("FIBTG", 0);
        }

        // Getters and setters for all fields

        public Double getENERC_KCAL() {
            return ENERC_KCAL;
        }

        public void setENERC_KCAL(Double ENERC_KCAL) {
            this.ENERC_KCAL = ENERC_KCAL;
        }

        public Double getPROCNT() {
            return PROCNT;
        }

        public void setPROCNT(Double PROCNT) {
            this.PROCNT = PROCNT;
        }

        public Double getFAT() {
            return FAT;
        }

        public void setFAT(Double FAT) {
            this.FAT = FAT;
        }

        public Double getCHOCDF() {
            return CHOCDF;
        }

        public void setCHOCDF(Double CHOCDF) {
            this.CHOCDF = CHOCDF;
        }

        public Double getFIBTG() {
            return FIBTG;
        }

        public void setFIBTG(Double FIBTG) {
            this.FIBTG = FIBTG;
        }

        @Override
        public String toString() {
            return "Nutrients [ENERC_KCAL=" + ENERC_KCAL + ", PROCNT=" + PROCNT + ", FAT=" + FAT + ", CHOCDF=" + CHOCDF
                    + ", FIBTG=" + FIBTG + "]";
        }
    }

    @Override
    public String toString() {
        return "Result [id=" + id + ", label=" + label + ", category=" + category + ", categoryLabel=" + categoryLabel
                + ", image=" + image + ", brand=" + brand + ", nutrients=" + nutrients + "]";
    }
}
