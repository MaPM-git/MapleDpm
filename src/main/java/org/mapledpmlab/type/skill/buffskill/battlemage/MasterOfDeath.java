package org.mapledpmlab.type.skill.buffskill.battlemage;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MasterOfDeath extends BuffSkill {
    public MasterOfDeath() {
        this.setName("마스터 오브 데스");
        this.setDuration(30L);
        this.setCooldown(180.0);
        this.setDelay(1020L);
    }
}
