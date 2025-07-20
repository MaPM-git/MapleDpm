package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterSecretInfiniteBlades extends AttackSkill {
    public SoulshatterSecretInfiniteBlades() {
        this.setName("망혼검 절기 : 무량겁");
        this.setDelayByAttackSpeed(660L);
        this.setAttackCount(7L);
        this.setDamage(610.0);
        this.setRelatedSkill(new SoulshatterSecretInfiniteBladesFlame());
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 망혼강림-리인포스
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
