package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CheeringBalloonFinale extends AttackSkill {
    public CheeringBalloonFinale() {
        this.setName("응원 풍선(대미)");
        this.setDamage(490.0);
        this.setAttackCount(1L);
        this.setDotDuration(3000L);
        this.setInterval(6L);
        this.setLimitAttackCount(245L);
        this.setAddDamage(20L);     // 소울 시커-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.75);
        /*this.getMultiAttackInfo().add(510L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);*/
    }
}
