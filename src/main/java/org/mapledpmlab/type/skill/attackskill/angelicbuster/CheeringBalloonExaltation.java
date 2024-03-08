package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CheeringBalloonExaltation extends AttackSkill {
    public CheeringBalloonExaltation() {
        this.setName("응원 풍선(소울 익절트)");
        this.setDamage(673.0);
        this.setAttackCount(1L);
        this.setDotDuration(2130L);
        this.setInterval(60L);
        this.setLimitAttackCount(28L);
        this.addFinalDamage(0.55);
        this.setAddDamage(20L);     // 소울 시커-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.75);
        /*this.getMultiAttackInfo().add(510L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);*/
    }
}
