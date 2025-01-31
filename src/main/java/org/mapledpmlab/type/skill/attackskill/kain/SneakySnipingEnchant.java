package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SneakySnipingEnchant extends AttackSkill {
    public SneakySnipingEnchant() {
        this.setName("[발현/처형] 스니키 스나이핑");
        this.setDamage(548.0);
        this.setAttackCount(12L);
        this.setDelayByAttackSpeed(270L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
