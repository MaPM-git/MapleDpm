package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CheeringBalloon extends AttackSkill {
    public CheeringBalloon() {
        this.setName("응원 풍선");
        this.setDamage(673.0);
        this.setAttackCount(1L);
        this.setDotDuration(2070L);
        this.setInterval(120L);
        this.setLimitAttackCount(14L);
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
