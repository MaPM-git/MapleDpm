package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ElementalBlast extends AttackSkill {
    public ElementalBlast() {
        this.setName("엘리멘탈 블래스트");
        this.setDamage(1705.0);
        this.setAttackCount(8L);
        this.setDotDuration(780L);
        this.setInterval(195L);
        this.setLimitAttackCount(4L);
        this.setCooldown(40.0);             // 코어 강화
        this.addFinalDamage(1.6);
        this.setRelatedSkill(new ElementalBlastDelay());
    }
}
