package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlissfulRestraintFinish extends AttackSkill {
    public BlissfulRestraintFinish() {
        this.setName("황홀한 구속(막타)");
        this.setDamage(375.0);
        this.setAttackCount(8L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(9000L);
        this.setRelatedSkill(new BlissfulRestraint());
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
