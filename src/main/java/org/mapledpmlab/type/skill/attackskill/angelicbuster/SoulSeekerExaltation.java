package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulSeekerExaltation extends AttackSkill {
    public SoulSeekerExaltation() {
        this.setName("소울 시커(소울 익절트)");
        this.setDamage(432.0);
        this.setAttackCount(1L);
        this.setDotDuration(3000L);
        this.setInterval(60L);
        this.setLimitAttackCount(28L);
        this.setAddDamage(20L);     // 소울 시커-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.75);
        this.addFinalDamage(0.55);
        /*this.getMultiAttackInfo().add(510L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);*/
    }
}
