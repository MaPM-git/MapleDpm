package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterSecretMindBladeForce extends AttackSkill {
    public SoulshatterSecretMindBladeForce() {
        this.setName("망혼검 절기 : 심검(검기)");
        this.setAttackCount(3L);
        this.setDamage(1500.0);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setAddDamage(20L);             // 망혼강림-리인포스
        this.getMultiAttackInfo().add(450L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
