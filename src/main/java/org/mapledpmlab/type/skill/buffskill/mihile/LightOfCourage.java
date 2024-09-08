package org.mapledpmlab.type.skill.buffskill.mihile;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.mihile.LightOfCourageAttack;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LightOfCourage extends BuffSkill {
    public LightOfCourage() {
        this.setName("라이트 오브 커리지");
        this.setBuffDamage(40L);
        this.setCooldown(90.0);
        this.setDelay(750L);
        this.setDuration(35L);
        this.setRelatedSkill(new LightOfCourageAttack());
    }
}
