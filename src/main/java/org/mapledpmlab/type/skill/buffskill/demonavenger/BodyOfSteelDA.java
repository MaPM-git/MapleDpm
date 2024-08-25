package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

import java.sql.Timestamp;

@Getter
@Setter
public class BodyOfSteelDA extends GaugeBuffSkill {
    public BodyOfSteelDA(Long burningTime) {
        this.setName("바디 오브 스틸");
        this.addBuffDamage(burningTime / 1000 * 6);
        this.setDelay(720L);
        this.setDuration(18L);
        this.setCooldown(120.0);
        this.setGaugePer(-3L);
    }
}
