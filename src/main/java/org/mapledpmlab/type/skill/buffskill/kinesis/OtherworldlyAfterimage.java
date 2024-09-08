package org.mapledpmlab.type.skill.buffskill.kinesis;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class OtherworldlyAfterimage extends BuffSkill {
    public OtherworldlyAfterimage(int level) {
        this.setName("이계의 잔상");
        this.setCooldown(60.0);
        this.setDelay(630L);
        this.setDuration(50L);
        this.addBuffCriticalDamage(5.0);
        this.addBuffMainStat((long) ((level + 2) * 5 * 0.5));
    }
}
