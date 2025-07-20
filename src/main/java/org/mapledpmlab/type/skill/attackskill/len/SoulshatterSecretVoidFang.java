package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterSecretVoidFang extends AttackSkill {
    public SoulshatterSecretVoidFang() {
        this.setName("망혼검 절기 : 망탄");
        this.setDelayByAttackSpeed(660L);
        this.setAttackCount(9L);
        this.setDamage(2250.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 망혼강림-리인포스
        this.setApplyFinalAttack(true);
    }
}
