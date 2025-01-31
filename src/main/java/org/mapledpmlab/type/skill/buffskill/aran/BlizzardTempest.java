package org.mapledpmlab.type.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.aran.IceBlock;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BlizzardTempest extends BuffSkill {
    public BlizzardTempest() {
        this.setName("블리자드 템페스트");
        this.setDuration(30L);
        this.setCooldown(90.0);
        this.setDelayByAttackSpeed(720L);
        this.setRelatedSkill(new IceBlock());
    }
}
