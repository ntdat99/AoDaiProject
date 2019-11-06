package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import net.bytebuddy.pool.TypePool;


    @Data
    @Getter
    @Setter
    @Entity
    public class Fabric {
        @javax.persistence.Id
        private int Id;
        private String description;
        private String color;
        private String image;
        private int fabric;


        public enum FABRIC {

            COTTON(1), CHIFFON(2), VOAN(3), REN(4), SILK(4);

            private int value;

            FABRIC(int i) {
                this.value = i;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

    }
