package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.hero.IncisingAttack;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class EpicAdventure extends BuffSkill {
    public EpicAdventure() {
        this.setName("에픽 어드벤처");
        this.setCooldown(120.0);
        this.setDuration(60L);
        this.setBuffDamage(10L);
    }
}
