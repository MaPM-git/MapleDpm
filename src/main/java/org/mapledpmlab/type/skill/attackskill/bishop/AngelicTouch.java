package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AngelicTouch extends AttackSkill {
    public AngelicTouch() {
        this.setName("엔젤릭 터치");
        this.setDamage(590.0);
        this.setAttackCount(7L);
        this.setCooldown(10.0);
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(3.4);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyFinalAttack(true);
    }
}
