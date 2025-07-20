package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterSecretTearGround2 extends AttackSkill {
    public SoulshatterSecretTearGround2() {
        this.setName("망혼검 절기 : 열지(검격)");
        this.setAttackCount(7L);
        this.setDamage(1350.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 망혼강림-리인포스
        this.setApplyFinalAttack(true);
    }
}
