package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.windbreaker.WindWall;

public class StoneWind extends AttackSkill {
    public StoneWind() {
        this.setName("윈드 월(돌개바람)");
        this.setAttackCount(5L);
        this.setDamage(1210.0);
        this.addFinalDamage(0.5);
        this.addFinalDamage(1.6);       // 코어강화
        this.setDotDuration(60000L);
        this.setLimitAttackCount(90L);
        this.setInterval(666L);
        this.setRelatedSkill(new WindWall());
        this.setCooldown(90.0);
    }
}
