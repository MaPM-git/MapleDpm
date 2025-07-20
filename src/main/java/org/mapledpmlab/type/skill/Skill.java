package org.mapledpmlab.type.skill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Skill {
    @JsonIgnore
    private Timestamp activateTime = new Timestamp(0);
    private Double cooldown = 0.0;
    private Long delay = 0L;
    @JsonIgnore
    private String description = "";
    private boolean isApplyCooldownReduction = true;
    private boolean isApplyReuse = false;
    private String name = "";
    @JsonIgnore
    private Skill relatedSkill = null;
    private boolean isApplyServerLag = false;

    public void setDelayByAttackSpeed(Long delay) {
        Double tmp = delay * 0.75;
        Long q = 0L;
        if (tmp % 30 != 0) {
            q = (long) (tmp / 30);
            q = (q + 1) * 30;
        } else {
            q = tmp.longValue();
        }
        this.setDelay(q);
    }
}
