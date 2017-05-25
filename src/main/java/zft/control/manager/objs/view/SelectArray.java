package zft.control.manager.objs.view;

import java.io.Serializable;
import java.util.List;

public class SelectArray implements Serializable {
    private List<Select> items;
    private Integer limit;
    private Integer total;

    public List<Select> getItems() {
        return items;
    }

    public void setItems(List<Select> items) {
        this.items = items;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static class Select {
        private String id;
        private String text;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
