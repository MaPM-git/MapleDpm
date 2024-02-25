package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateDrive extends AttackSkill {
    public UltimateDrive() {
        this.setName("얼티밋 드라이브");
        this.setAttackCount(3L);
        this.setDamage(450.0);
        this.setDelay(150L);
        this.setAddDamage(20L);         // 얼티밋 드라이브-리인포스
        this.addIgnoreDefenseList(20L); // 얼티밋 드라이브-이그노어 가드
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
