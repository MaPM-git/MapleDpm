package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EssenceSprinkle extends AttackSkill {
    public EssenceSprinkle() {
        this.setName("정기 뿌리기");
        this.setDamage(840.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(660L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setAddDamage(15L);     // 정기 뿌리기-보스 킬러
    }
}
