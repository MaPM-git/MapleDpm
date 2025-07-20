package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterSecretMindBlade extends AttackSkill {
    public SoulshatterSecretMindBlade() {
        this.setName("망혼검 절기 : 심검");
        this.setDelayByAttackSpeed(660L);
        this.setAttackCount(10L);
        this.setDamage(1200.0);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setAddDamage(20L);             // 망혼강림-리인포스
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new SoulshatterSecretMindBladeForce());
    }
}
