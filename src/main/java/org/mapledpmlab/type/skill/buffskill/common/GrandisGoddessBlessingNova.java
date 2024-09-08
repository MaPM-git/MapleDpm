package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GrandisGoddessBlessingNova extends BuffSkill {
    public GrandisGoddessBlessingNova() {
        this.setName("그란디스 여신의 축복(노바)");
        this.setDelay(630L);
        this.setDuration(40L);
        this.setBuffDamage(35L);
        this.setCooldown(120.0);
    }
}
