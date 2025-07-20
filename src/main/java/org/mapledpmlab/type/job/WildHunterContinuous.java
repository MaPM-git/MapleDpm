package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossCritical;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.CygnusBlessing;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Link;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class WildHunterContinuous extends Job {

    public WildHunterContinuous() {
        // 기본
        super();
        this.setName("와일드헌터(0초, 컨티)");
        this.setConstant(1.35);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2803045.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (326 + 201 + 72 + 249));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (326 + 201 + 72 + 249));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("재규어");
        passive.addCriticalP(5.0);
        passive.addPlusBuffDuration(10L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("서먼 재규어");
        passive.addCriticalDamage(8.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("오토매틱 슈팅 디바이스");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("네이처스 라스");
        passive.addCriticalP(25.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("소울 애로우 : 석궁");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하울링");
        passive.addAttP(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("크로스보우 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("크로스보우 마스터리");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("티타늄 화살");
        passive.addAtt(9L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("비스트 폼");
        passive.addAttP(25L);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("플러리");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("재규어 링크");
        passive.addCriticalP(18.0);
        passive.addCriticalDamage(12.0);
        passive.addAtt(10L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("샤프 아이즈");
        passive.addCriticalP(21.0 - 10);
        passive.addCriticalDamage(16.0 - 8);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("익스텐드 매거진");
        passive.addFinalDamage(1.2);
        passive.addMainStat(62L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("크로스보우 엑스퍼트");
        passive.addAtt(31L);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("와일드 인스팅트");
        passive.addIgnoreDefenseList(33L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 파이널 어택");
        passive.addAtt(21L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("재규어 스톰");
        passive.addAtt(65L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-60L);
        this.addMainStat(-4L);
        this.addSubStat(-5L);

        this.setAbility(new ReuseBossCritical());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        for (Link link : this.getLinkList()) {
            if (link instanceof CygnusBlessing) {
                this.getLinkList().remove(link);
                break;
            }
        }
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("하울링");
        doping.addAttP(-10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("세이람의 영약");
        doping.addCriticalP(-20.0);
        doping.addCriticalDamage(-16.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("익스텐드 매거진(콜렉터의 영약)");
        doping.addMainStat(2L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("크로스보우 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
