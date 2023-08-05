package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.bowmaster.QuiverFullBurstBuff;

public class QuiverFullBurst extends AttackSkill {
    public QuiverFullBurst() {
        this.setName("퀴버 풀버스트");
        this.setAttackCount(9L);
        this.setCooldown(120.0);
        this.setDamage(550.0);
        this.setDotDuration(40000L);
        this.setInterval(334L);
        this.setLimitAttackCount(18L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new QuiverFullBurstBuff());
    }
}
