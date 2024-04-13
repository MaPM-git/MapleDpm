package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.common.MastemaClaw;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CallMastema extends BuffSkill {
    public CallMastema() {
        this.setName("콜 마스테마");
        this.setCooldown(120.0);
        this.setDelay(690L);
        this.setDuration(48L);
        this.setRelatedSkill(new MastemaClaw());
    }
}
