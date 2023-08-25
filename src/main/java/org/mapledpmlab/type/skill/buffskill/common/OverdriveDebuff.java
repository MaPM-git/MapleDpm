package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class OverdriveDebuff extends BuffSkill {
    // 딜사이클 클래스에서 지속 시간 설정(쿨감 사용하는 직업 고려)
    // 적용 버프 목록 구할 때, 오버드라이브가 함께 적용되어 있으면 제외
    public OverdriveDebuff(Long att) {
        this.setName("오버 드라이브(디버프)");
        this.setCooldown(60.0);
        this.setDelay(540L);
        this.addBuffAttMagic(-(long) (att * 0.15));
    }
}
